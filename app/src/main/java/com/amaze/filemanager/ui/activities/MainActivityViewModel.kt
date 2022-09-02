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

package com.amaze.filemanager.ui.activities

import android.app.Application
import androidx.collection.LruCache
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.amaze.filemanager.adapters.data.LayoutElementParcelable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(val applicationContext: Application) :
    AndroidViewModel(applicationContext) {

    var mediaCacheHash: List<ArrayList<LayoutElementParcelable>?> = List(5) { null }
    var listCache: LruCache<String, ArrayList<LayoutElementParcelable>> = LruCache(50)

    companion object {
        /**
         * size of list to be cached for local files
         */
        val CACHE_LOCAL_LIST_THRESHOLD: Int = 100
    }

    /**
     * Put list for a given path in cache
     */
    fun putInCache(path: String, listToCache: ArrayList<LayoutElementParcelable>) {
        viewModelScope.launch(Dispatchers.Default) {
            listCache.put(path, listToCache)
        }
    }

    /**
     * Removes cache for a given path
     */
    fun evictPathFromListCache(path: String) {
        viewModelScope.launch(Dispatchers.Default) {
            listCache.remove(path)
        }
    }

    /**
     * Get cache from a given path and updates files / folder count
     */
    fun getFromListCache(path: String): ArrayList<LayoutElementParcelable>? {
        return listCache.get(path)
    }

    /**
     * Get cache from a given path and updates files / folder count
     */
    fun getFromMediaFilesCache(mediaType: Int): ArrayList<LayoutElementParcelable>? {
        return mediaCacheHash[mediaType]
    }
}
