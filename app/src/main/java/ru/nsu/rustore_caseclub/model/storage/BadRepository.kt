package ru.nsu.rustore_caseclub.model.storage

import ru.nsu.rustore_caseclub.model.AppInfo

class BadRepository: Repository {
    override fun getList(): List<AppInfo> {

    }

    override fun getScreenshots(id: Int): List<String> {
        TODO("Not yet implemented")
    }

}