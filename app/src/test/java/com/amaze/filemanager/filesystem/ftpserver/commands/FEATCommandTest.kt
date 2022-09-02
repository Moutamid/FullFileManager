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

package com.amaze.filemanager.filesystem.ftpserver.commands

import com.amaze.filemanager.R
import com.amaze.filemanager.application.AppConfig
import org.apache.ftpserver.impl.DefaultFtpRequest
import org.apache.ftpserver.impl.FtpIoSession
import org.apache.ftpserver.impl.FtpServerContext
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito

/**
 * Unit test for [FEAT].
 */
class FEATCommandTest : AbstractFtpserverCommandTest() {

    /**
     * Test command output. Expect AVBL is among list of extensions implemented.
     */
    @Test
    fun testCommand() {
        val context = Mockito.mock(FtpServerContext::class.java)
        val ftpSession = FtpIoSession(session, context)
        val command = FEAT()
        command.execute(
            session = ftpSession,
            context = context,
            request = DefaultFtpRequest("FEAT")
        )
        assertEquals(1, logger.messages.size)
        assertEquals(211, logger.messages[0].code)
        assertEquals(
            AppConfig.getInstance().getString(R.string.ftp_command_FEAT),
            logger.messages[0].message
        )
        assertTrue(logger.messages[0].message.contains("AVBL"))
    }
}
