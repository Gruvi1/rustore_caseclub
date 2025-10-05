package ru.nsu.rustore_caseclub.model

import kotlinx.serialization.Serializable

@Serializable
data class AppInfo(
    val id: String,
    val name: String,
    val category: String,
    val description: String,
    val icon: String,
    val screenshots: List<String>,
    val developerCompany: String,
    val ageRating: String
)