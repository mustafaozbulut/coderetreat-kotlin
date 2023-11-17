package be.swsb.coderetreat
import be.swsb.coderetreat.Game.Direction.HORIZONTAL
import be.swsb.coderetreat.Game.Direction.VERTICAL

class Game(private val player1: Player, private val player2: Player) {
    fun render(): String {
        val player1Board = player1.board().gameMap.map { row ->
            renderGameMap(row, player1)
        }.joinToString("\n")

        val player2Board = player2.board().gameMap.map { row ->
            renderGameMap(row, player2)
        }.joinToString("\n")

        return player1Board + "\n\n\n" + player2Board

    }

    private fun renderGameMap(row: Array<Position>, player: Player) = row.map { position ->
        when {
            anyShipPlacedAt(position, player) && !anyShipGotHit(position, player) -> "🛳"
            anyShipPlacedAt(position, player) && anyShipGotHit(position, player) && !shipSunk(position, player) -> "🔥"
            shipSunk(position, player) -> "🏊"
            else -> "🌊"
        }
    }.joinToString("")

    private fun shipSunk(position: Position, player: Player): Boolean {
        return player.board().ships().any { ship ->
            val positions = calculatePositionsFromSizeAndDirectionOf(ship)
            positions.contains(position) && player.board().firedPositions().containsAll(positions)
        }
    }

    private fun anyShipPlacedAt(position: Position, player: Player): Boolean {
        return placedShipPositions(player.board().ships()).contains(position)
    }

    private fun anyShipGotHit(position: Position, player: Player): Boolean {
        return player.board().firedPositions().contains(position)
    }

    private fun placedShipPositions(ships: Set<Ship>): List<Position> {
        val positions = mutableListOf<Position>()
        ships.map { ship ->
            positions.addAll(calculatePositionsFromSizeAndDirectionOf(ship))
        }
        return positions
    }

    private fun calculatePositionsFromSizeAndDirectionOf(ship: Ship): List<Position> {
        val calculatedPositions = mutableListOf<Position>()
        val position = ship.position()
        for (i in 0 until ship.size()) {
            if (ship.direction() == VERTICAL) {
                calculatedPositions.add(Position(position.first, position.second + i))
            }
            if (ship.direction() == HORIZONTAL) {
                calculatedPositions.add(Position(position.first + i, position.second))
            }
        }

        return calculatedPositions.toList()
    }

    class Player {
        private val board = Board(mutableSetOf())

        fun add(ship: Ship) {
            board.add(ship)
        }

        fun board(): Board {
            return board
        }

        fun fire(position: Position, board: Board) {
            board.setFiredPosition(position)
        }
    }

    class Board(private var ships: MutableSet<Ship>) {

        private val firedPositions = mutableListOf<Position>()

        val gameMap = Array(10) { row ->
            Array(10) { col ->
                Position(col + 1, row + 1)
            }
        }

        fun ships(): Set<Ship> {
            return ships
        }

        fun add(ship: Ship) {
            ships.add(ship)
        }

        fun setFiredPosition(position: Position) {
            firedPositions.add(position)
        }

        fun firedPositions(): List<Position> {
            return firedPositions.toList()
        }

    }

    class Ship(private var position: Position, private var direction: Direction, private var size: Int) {

        fun position(): Position {
            return position
        }

        fun setPosition(position: Position) {
            this.position = position
        }

        fun direction(): Direction {
            return direction
        }

        fun setDirection(direction: Direction) {
            this.direction = direction
        }

        fun size(): Int {
            return size
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Ship

            if (position != other.position) return false
            if (direction != other.direction) return false
            if (size != other.size) return false

            return true
        }

        override fun hashCode(): Int {
            var result = position.hashCode()
            result = 31 * result + direction.hashCode()
            result = 31 * result + size
            return result
        }

        companion object {
            fun carrier(): Ship = Ship(Position(0, 0), VERTICAL, 5)
            fun battleship() = Ship(Position(0, 0), VERTICAL, 4)
            fun destroyer() = Ship(Position(0, 0), VERTICAL, 3)
            fun submarine() = Ship(Position(0, 0), VERTICAL, 3)
            fun patrolBoat() = Ship(Position(0, 0), VERTICAL, 2)
        }


    }

    enum class Direction {
        VERTICAL,
        HORIZONTAL
    }

}
typealias Position = Pair<Int, Int>
