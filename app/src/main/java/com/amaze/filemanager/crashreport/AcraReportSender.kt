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

package com.amaze.filemanager.crashreport

import android.content.Context
import com.amaze.filemanager.R
import org.acra.data.CrashReportData
import org.acra.sender.ReportSender

class AcraReportSender : ReportSender {

    override fun send(context: Context, errorContent: CrashReportData) {
        ErrorActivity.reportError(
            context,
            errorContent,
            ErrorActivity.ErrorInfo.make(
                ErrorActivity.ERROR_UI_ERROR,
                "Application crash",
                R.string.app_ui_crash
            )
        )
    }

    override fun requiresForeground(): Boolean {
        return true
    }
}
