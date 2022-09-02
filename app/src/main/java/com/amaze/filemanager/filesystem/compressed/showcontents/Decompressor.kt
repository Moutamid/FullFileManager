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

package com.amaze.filemanager.filesystem.compressed.showcontents

import android.content.Context
import android.content.Intent
import com.amaze.filemanager.asynchronous.asynctasks.compress.CompressedHelperCallable
import com.amaze.filemanager.asynchronous.management.ServiceWatcherUtil
import com.amaze.filemanager.asynchronous.services.ExtractService

/** @author Emmanuel on 20/11/2017, at 17:14.
 */
abstract class Decompressor(protected var context: Context) {

    lateinit var filePath: String

    /**
     * Separator must be "/"
     *
     * @param path end with "/" if it is a directory, does not if it's a file
     */
    abstract fun changePath(
        path: String,
        addGoBackItem: Boolean
    ): CompressedHelperCallable

    /** Decompress a file somewhere  */
    fun decompress(whereToDecompress: String) {
        val intent = Intent(context, ExtractService::class.java).also {
            it.putExtra(ExtractService.KEY_PATH_ZIP, filePath)
            it.putExtra(ExtractService.KEY_ENTRIES_ZIP, arrayOfNulls<String>(0))
            it.putExtra(ExtractService.KEY_PATH_EXTRACT, whereToDecompress)
        }
        ServiceWatcherUtil.runService(context, intent)
    }

    /**
     * Decompress files or dirs inside the compressed file.
     *
     * @param subDirectories separator is "/", ended with "/" if it is a directory, does not if it's a
     * file
     */
    fun decompress(whereToDecompress: String, subDirectories: Array<String?>) {
        subDirectories.filterNotNull().map {
            realRelativeDirectory(it)
        }.run {
            val intent = Intent(context, ExtractService::class.java).also {
                it.putExtra(ExtractService.KEY_PATH_ZIP, filePath)
                it.putExtra(ExtractService.KEY_ENTRIES_ZIP, subDirectories)
                it.putExtra(ExtractService.KEY_PATH_EXTRACT, whereToDecompress)
            }
            ServiceWatcherUtil.runService(context, intent)
        }
    }

    /** Get the real relative directory path (useful if you converted the separator or something)  */
    protected open fun realRelativeDirectory(dir: String): String {
        return dir
    }
}
