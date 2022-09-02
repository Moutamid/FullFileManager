/*
 * Copyright (c) 2022 FullDive
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.database.models.utilities

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Test [List] model.
 */
@Suppress("StringLiteralDuplication")
class ListTest {

    /**
     * Test [List.equals] for equality.
     */
    @Test
    fun testEquals() {
        val a = List("/storage/emulated/0")
        val b = List("/storage/emulated/0")
        assertEquals(a, b)
        assertEquals(a.hashCode(), b.hashCode())
    }

    /**
     * Test [List.equals] for inequality.
     */
    @Test
    fun testNotEquals() {
        val a = List("/storage/emulated/0")
        val b = List("/storage/emulated/1")
        assertNotEquals(a, b)
        assertNotEquals(a.hashCode(), b.hashCode())
    }

    /**
     * Test [List.equals] for inequality with other class.
     */
    @Test
    fun testForeignClassNotEquals() {
        val a = List("/storage/emulated/1")
        val b = Grid("/storage/emulated/1")
        assertNotEquals(a, b)
        assertNotEquals(a.hashCode(), b.hashCode())
    }
}
