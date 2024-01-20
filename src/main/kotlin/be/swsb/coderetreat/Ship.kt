package be.swsb.coderetreat

class Ship(private var position: Position, private var direction: Game.Direction, private var size: Int) {

    fun position(): Position {
        return position
    }

    fun setPosition(position: Position) {
        this.position = position
    }

    fun direction(): Game.Direction {
        return direction
    }

    fun setDirection(direction: Game.Direction) {
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
        fun carrier(): Ship = Ship(Position(0, 0), Game.Direction.VERTICAL, 5)
        fun battleship() = Ship(Position(0, 0), Game.Direction.VERTICAL, 4)
        fun destroyer() = Ship(Position(0, 0), Game.Direction.VERTICAL, 3)
        fun submarine() = Ship(Position(0, 0), Game.Direction.VERTICAL, 3)
        fun patrolBoat() = Ship(Position(0, 0), Game.Direction.VERTICAL, 2)
    }


}

