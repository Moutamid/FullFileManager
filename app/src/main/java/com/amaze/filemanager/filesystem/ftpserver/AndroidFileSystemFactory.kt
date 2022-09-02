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

package com.amaze.filemanager.filesystem.ftpserver

import android.content.Context
import android.os.Build.VERSION_CODES.KITKAT
import androidx.annotation.RequiresApi
import com.amaze.filemanager.asynchronous.services.ftp.FtpService
import org.apache.ftpserver.ftplet.FileSystemFactory
import org.apache.ftpserver.ftplet.FileSystemView
import org.apache.ftpserver.ftplet.User

@RequiresApi(KITKAT)
class AndroidFileSystemFactory(private val context: Context) : FileSystemFactory {

    override fun createFileSystemView(user: User?): FileSystemView =
        AndroidFtpFileSystemView(context, user?.homeDirectory ?: FtpService.defaultPath(context))
}
