package be.swsb.coderetreat

import be.swsb.coderetreat.Game.*
import be.swsb.coderetreat.Game.Direction.HORIZONTAL
import be.swsb.coderetreat.Game.Direction.VERTICAL
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class GameTest {

    @Test
    fun `board has ships`() {
        val player1 = Player()
        val ship1 = Ship.battleship()
        val ship2 = Ship.carrier()

        player1.add(ship1)
        player1.add(ship2)

        assertThat(player1.board().ships()).containsExactlyInAnyOrder(ship1, ship2)
    }

    @Test
    fun `each board of each player has ships`() {
        val player1 = Player()
        val player2 = Player()
        val ship1 = Ship.battleship()
        val ship2 = Ship.carrier()

        player1.add(ship1)
        player1.add(ship2)
        player2.add(ship1)
        player2.add(ship2)

        assertThat(player1.board().ships()).containsExactlyInAnyOrder(Ship.battleship(), Ship.carrier())
        assertThat(player2.board().ships()).containsExactlyInAnyOrder(Ship.battleship(), Ship.carrier())
    }

    @Test
    fun `a ship has position`() {
        val ship = Ship.battleship()
        ship.setPosition(Pair(1, 1))

        assertThat(ship.position()).isEqualTo(Pair(1, 1))
    }

    @Test
    fun `a ship has direction`() {
        val ship1 = Ship.battleship()
        ship1.setDirection(VERTICAL)

        assertThat(ship1.direction()).isEqualTo(VERTICAL)
    }

    @Test
    fun `ships have sizes`() {
        val battleship = Ship.battleship()
        val carrier = Ship.carrier()
        val destroyer = Ship.destroyer()
        val submarine = Ship.submarine()
        val patrolboat = Ship.patrolBoat()

        assertThat(carrier.size()).isEqualTo(5)
        assertThat(battleship.size()).isEqualTo(4)
        assertThat(destroyer.size()).isEqualTo(3)
        assertThat(submarine.size()).isEqualTo(3)
        assertThat(patrolboat.size()).isEqualTo(2)
    }

    @Test
    fun `board of a player has no ship when game starts`() {
        val player1 = Player()
        val player2 = Player()

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            

            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        """.trimIndent()
        )
    }

    @Test
    fun `player adds a battleship to position (1,1) horizontally`() {
        val player1 = Player()
        val player2 = Player()


        val battleship = Ship.battleship()
        battleship.setPosition(Pair(1, 1))
        battleship.setDirection(HORIZONTAL)
        player1.add(battleship)

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🛳🛳🛳🛳🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            
            
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        """.trimIndent()
        )
    }

    @Test
    fun `player adds a battleship to position (1,1) vertically`() {
        val player1 = Player()
        val player2 = Player()

        val battleship = Ship.battleship()
        battleship.setPosition(Pair(1, 1))
        battleship.setDirection(VERTICAL)
        player1.add(battleship)

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🛳🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🛳🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🛳🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🛳🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            

            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        """.trimIndent()
        )
    }

    @Test
    fun `player adds a battleship to position (5,7) vertically`() {
        val player1 = Player()
        val player2 = Player()

        val battleship = Ship.battleship()
        battleship.setPosition(Pair(5, 7))
        battleship.setDirection(VERTICAL)
        player1.add(battleship)

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🛳🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🛳🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🛳🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🛳🌊🌊🌊🌊🌊
            

            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        """.trimIndent()
        )
    }

    @Test
    fun `player adds a battleship to position (6,2) vertically`() {
        val player1 = Player()
        val player2 = Player()

        val carrier = Ship.carrier()
        carrier.setPosition(Pair(6, 2))
        carrier.setDirection(VERTICAL)
        player1.add(carrier)

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            

            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        """.trimIndent()
        )
    }

    @Test
    fun `player adds a submarine to position (3,3) vertically and a battleship to (7,7) horizontally`() {
        val player1 = Player()
        val player2 = Player()

        val submarine = Ship.submarine()
        submarine.setPosition(Pair(3, 3))
        submarine.setDirection(VERTICAL)
        player1.add(submarine)

        val battleship = Ship.battleship()
        battleship.setPosition(Pair(7, 7))
        battleship.setDirection(HORIZONTAL)
        player1.add(battleship)

        val carrier = Ship.carrier()
        carrier.setPosition(Pair(3, 4))
        carrier.setDirection(VERTICAL)
        player2.add(carrier)


        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🛳🛳🛳🛳
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            
            
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        """.trimIndent()
        )
    }

    @Test
    fun `player adds all ships`() {
        val player1 = Player()
        val player2 = Player()

        val carrier = Ship.carrier()
        carrier.setPosition(Pair(1, 1))
        carrier.setDirection(HORIZONTAL)
        player1.add(carrier)

        val battleship = Ship.battleship()
        battleship.setPosition(Pair(3, 3))
        battleship.setDirection(VERTICAL)
        player1.add(battleship)

        val destroyer = Ship.destroyer()
        destroyer.setPosition(Pair(4, 4))
        destroyer.setDirection(HORIZONTAL)
        player1.add(destroyer)

        val submarine = Ship.submarine()
        submarine.setPosition(Pair(6, 6))
        submarine.setDirection(VERTICAL)
        player1.add(submarine)


        val petrolBoat = Ship.patrolBoat()
        petrolBoat.setPosition(Pair(7, 7))
        petrolBoat.setDirection(HORIZONTAL)
        player1.add(petrolBoat)


        assertThat(Game(player1, player2).render()).isEqualTo(
                    """
        🛳🛳🛳🛳🛳🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🛳🛳🛳🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🛳🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🛳🛳🛳🌊🌊
        🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        
        
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
""".trimIndent()
        )
    }


    @Test
    fun `player fires and misses`() {
        val player1 = Player()
        val player2 = Player()

        val carrier2 = Ship.carrier()
        carrier2.setPosition(Pair(1, 1))
        carrier2.setDirection(HORIZONTAL)
        player2.add(carrier2)

        val battleship2 = Ship.battleship()
        battleship2.setPosition(Pair(3, 3))
        battleship2.setDirection(VERTICAL)
        player2.add(battleship2)

        val destroyer2 = Ship.destroyer()
        destroyer2.setPosition(Pair(4, 4))
        destroyer2.setDirection(HORIZONTAL)
        player2.add(destroyer2)

        val submarine2 = Ship.submarine()
        submarine2.setPosition(Pair(6, 6))
        submarine2.setDirection(VERTICAL)
        player2.add(submarine2)


        val petrolBoat2 = Ship.patrolBoat()
        petrolBoat2.setPosition(Pair(7, 7))
        petrolBoat2.setDirection(HORIZONTAL)
        player2.add(petrolBoat2)

        val carrier1 = Ship.carrier()
        carrier1.setPosition(Pair(1, 1))
        carrier1.setDirection(HORIZONTAL)
        player1.add(carrier1)

        val battleship1 = Ship.battleship()
        battleship1.setPosition(Pair(3, 3))
        battleship1.setDirection(VERTICAL)
        player1.add(battleship1)

        val destroyer1 = Ship.destroyer()
        destroyer1.setPosition(Pair(4, 4))
        destroyer1.setDirection(HORIZONTAL)
        player1.add(destroyer1)

        val submarine1 = Ship.submarine()
        submarine1.setPosition(Pair(6, 6))
        submarine1.setDirection(VERTICAL)
        player1.add(submarine1)


        val petrolBoat1 = Ship.patrolBoat()
        petrolBoat1.setPosition(Pair(7, 7))
        petrolBoat1.setDirection(HORIZONTAL)
        player1.add(petrolBoat1)

        player2.fire(Pair(5, 5), player1.board())

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
        🛳🛳🛳🛳🛳🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🛳🛳🛳🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🛳🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🛳🛳🛳🌊🌊
        🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        
        
        🛳🛳🛳🛳🛳🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🛳🛳🛳🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🛳🌊🌊🛳🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🛳🛳🛳🌊🌊
        🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
        """.trimIndent()
        )

    }

    @Test
    fun `player fires and hits`() {
        val player1 = Player()
        val player2 = Player()

        val carrier = Ship.carrier()
        carrier.setPosition(Pair(1, 1))
        carrier.setDirection(HORIZONTAL)
        player1.add(carrier)

        val carrier2 = Ship.carrier()
        carrier2.setPosition(Pair(1, 1))
        carrier2.setDirection(HORIZONTAL)
        player2.add(carrier2)

        val battleship = Ship.battleship()
        battleship.setPosition(Pair(3, 3))
        battleship.setDirection(VERTICAL)
        player1.add(battleship)

        val destroyer = Ship.destroyer()
        destroyer.setPosition(Pair(4, 4))
        destroyer.setDirection(HORIZONTAL)
        player1.add(destroyer)

        val submarine = Ship.submarine()
        submarine.setPosition(Pair(6, 6))
        submarine.setDirection(VERTICAL)
        player1.add(submarine)


        val petrolBoat = Ship.patrolBoat()
        petrolBoat.setPosition(Pair(7, 7))
        petrolBoat.setDirection(HORIZONTAL)
        player1.add(petrolBoat)

        player2.fire(Pair(5, 4), player1.board())
        player2.fire(Pair(6, 4), player1.board())
        player1.fire(Pair(1, 1), player2.board())

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🛳🛳🛳🛳🛳🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🛳🔥🔥🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🛳🛳🛳🌊🌊
            🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            

            🔥🛳🛳🛳🛳🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            """.trimIndent()
        )

    }

    @Test
    fun `player fires and sinks the ship`() {
        val player1 = Player()
        val player2 = Player()

        val carrier = Ship.carrier()
        carrier.setPosition(Pair(1, 1))
        carrier.setDirection(HORIZONTAL)
        player1.add(carrier)

        val battleship = Ship.battleship()
        battleship.setPosition(Pair(3, 3))
        battleship.setDirection(VERTICAL)
        player1.add(battleship)

        val destroyer = Ship.destroyer()
        destroyer.setPosition(Pair(4, 4))
        destroyer.setDirection(HORIZONTAL)
        player1.add(destroyer)

        val submarine = Ship.submarine()
        submarine.setPosition(Pair(6, 6))
        submarine.setDirection(VERTICAL)
        player1.add(submarine)


        val petrolBoat = Ship.patrolBoat()
        petrolBoat.setPosition(Pair(7, 7))
        petrolBoat.setDirection(HORIZONTAL)
        player1.add(petrolBoat)

        player2.fire(Pair(4, 4), player1.board())
        player2.fire(Pair(5, 4), player1.board())
        player2.fire(Pair(6, 4), player1.board())

        assertThat(Game(player1, player2).render()).isEqualTo(
            """
            🛳🛳🛳🛳🛳🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🏊🏊🏊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🛳🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🛳🛳🛳🌊🌊
            🌊🌊🌊🌊🌊🛳🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            

            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
            """.trimIndent()
        )

    }


}

