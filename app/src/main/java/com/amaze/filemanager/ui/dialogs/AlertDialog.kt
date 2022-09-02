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

package com.amaze.filemanager.ui.dialogs

import androidx.annotation.Nullable
import androidx.annotation.StringRes
import com.afollestad.materialdialogs.MaterialDialog
import com.amaze.filemanager.ui.activities.superclasses.ThemedActivity

/**
 * Alert Dialog.
 */
object AlertDialog {

    /**
     * Display an alert dialog. Optionally accepts a [MaterialDialog.SingleButtonCallback] to
     * provide additional behaviour when dialog button is pressed.
     *
     * Button default text is OK, but can be customized too.
     */
    @JvmStatic
    fun show(
        activity: ThemedActivity,
        @StringRes content: Int,
        @StringRes title: Int,
        @StringRes positiveButtonText: Int = android.R.string.ok,
        @Nullable onPositive: MaterialDialog.SingleButtonCallback? = null,
        contentIsHtml: Boolean = false
    ) {
        val accentColor: Int = activity.accent
        val a = MaterialDialog.Builder(activity)
            .content(content, contentIsHtml)
            .widgetColor(accentColor)
            .theme(
                activity
                    .appTheme
                    .getMaterialDialogTheme(activity.applicationContext)
            )
            .title(title)
            .positiveText(positiveButtonText)
            .positiveColor(accentColor)

        if (onPositive != null) {
            a.onPositive(onPositive)
        }
        a.build().show()
    }
}
