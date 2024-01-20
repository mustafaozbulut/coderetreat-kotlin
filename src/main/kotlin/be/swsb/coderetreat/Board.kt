import be.swsb.coderetreat.Position
import be.swsb.coderetreat.Ship

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
