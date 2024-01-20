package be.swsb.coderetreat
import Player
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



    enum class Direction {
        VERTICAL,
        HORIZONTAL
    }

}
typealias Position = Pair<Int, Int>
