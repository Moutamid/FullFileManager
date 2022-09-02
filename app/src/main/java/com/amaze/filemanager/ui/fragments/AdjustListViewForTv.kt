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

package com.amaze.filemanager.ui.fragments

import androidx.recyclerview.widget.RecyclerView
import com.amaze.filemanager.ui.activities.MainActivity

interface AdjustListViewForTv<in T : RecyclerView.ViewHolder> {
    /**
     * Adjust list view focus scroll when using dpad.
     * Scroll few more elements up / down so that it's easier for user to see list
     */
    fun adjustListViewForTv(viewHolder: T, mainActivity: MainActivity)
}
