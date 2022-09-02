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

import com.amaze.filemanager.fileoperations.filesystem.compressed.ArchivePasswordCache
import java.io.File

class ListEncryptedSevenZipHelperCallableTest : AbstractCompressedHelperCallableArchiveTest() {

    override val archiveFileName: String
        get() = "test-archive-encrypted-list.7z"

    override fun doCreateCallable(archive: File, relativePath: String): CompressedHelperCallable {
        archive.absolutePath.let {
            ArchivePasswordCache.getInstance()[it] = "123456"
            return SevenZipHelperCallable(it, relativePath, false)
        }
    }
}
