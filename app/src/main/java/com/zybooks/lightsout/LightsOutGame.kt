package com.zybooks.lightsout

import kotlin.random.Random

const val GRID_SIZE = 3

class LightsOutGame {

    private val lightsGrid = Array(GRID_SIZE) { Array(GRID_SIZE) { true } }

    fun turnAllLightsOff() {
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                lightsGrid[row][col] = false
            }
        }
    }

    fun newGame() {
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                lightsGrid[row][col] = Random.nextBoolean()
            }
        }
    }

    fun isLightOn(row: Int, col: Int): Boolean {
        return lightsGrid[row][col]
    }

    fun selectLight(row: Int, col: Int) {
        lightsGrid[row][col] = !lightsGrid[row][col]
        if (row > 0) {
            lightsGrid[row - 1][col] = !lightsGrid[row - 1][col]
        }
        if (row < GRID_SIZE - 1) {
            lightsGrid[row + 1][col] = !lightsGrid[row + 1][col]
        }
        if (col > 0) {
            lightsGrid[row][col - 1] = !lightsGrid[row][col - 1]
        }
        if (col < GRID_SIZE - 1) {
            lightsGrid[row][col + 1] = !lightsGrid[row][col + 1]
        }
    }

    val isGameOver: Boolean
        get() {
            for (row in 0 until GRID_SIZE) {
                for (col in 0 until GRID_SIZE) {
                    if (lightsGrid[row][col]) {
                        return false
                    }
                }
            }
            return true
        }

    var state: BooleanArray
        get() {
            // Return Boolean array
            val gameBoardArray1 = BooleanArray(9)
            var index = 0
            for (row in 0 until GRID_SIZE) {
                for (col in 0 until GRID_SIZE) {
                    gameBoardArray1[index] = lightsGrid[row][col]
                    index++
                }
            }
            return gameBoardArray1
        }
        set(value) {
            var index = 0
            for (row in 0 until GRID_SIZE) {
                for (col in 0 until GRID_SIZE) {
                    /*if(lightsGrid[row][col] == value[index])
                    {
                        lightsGrid[row][col] = value[index] == true
                    }*/
                    lightsGrid[row][col] = value[index]
                    index++
                }
            }
        }
}