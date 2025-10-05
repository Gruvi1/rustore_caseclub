package ru.nsu.rustore_caseclub.model.storage

import ru.nsu.rustore_caseclub.model.AppInfo

interface Repository {
    fun getList(): List<AppInfo>
    fun getScreenshots(id: Int): List<String>
}