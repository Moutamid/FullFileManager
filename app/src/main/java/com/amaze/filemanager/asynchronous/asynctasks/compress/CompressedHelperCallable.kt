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

package com.amaze.filemanager.asynchronous.asynctasks.compress

import androidx.annotation.WorkerThread
import com.amaze.filemanager.adapters.data.CompressedObjectParcelable
import org.apache.commons.compress.archivers.ArchiveException
import java.util.*
import java.util.concurrent.Callable

abstract class CompressedHelperCallable internal constructor(
    private val createBackItem: Boolean
) :
    Callable<ArrayList<CompressedObjectParcelable>> {

    @WorkerThread
    @Throws(ArchiveException::class)
    override fun call(): ArrayList<CompressedObjectParcelable> {
        val elements = ArrayList<CompressedObjectParcelable>()
        if (createBackItem) {
            elements.add(0, CompressedObjectParcelable())
        }

        addElements(elements)
        Collections.sort(elements, CompressedObjectParcelable.Sorter())
        return elements
    }

    @Throws(ArchiveException::class)
    protected abstract fun addElements(elements: ArrayList<CompressedObjectParcelable>)
}
