import be.swsb.coderetreat.Position
import be.swsb.coderetreat.Ship

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
