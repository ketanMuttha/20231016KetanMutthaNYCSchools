package com.nyc.schools.data.model.details

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SchoolSatScoresTO(
    val dbn: String = "",
    @SerializedName("num_of_sat_test_takers")
    val numsOfTestTakers: String = "",
    @SerializedName("sat_critical_reading_avg_score")
    val readingAvgScore: String = "",
    @SerializedName("sat_math_avg_score")
    val satMathAvgScore: String = "",
    @SerializedName("sat_writing_avg_score")
    val satWritingAvgScore: String = "",
    @SerializedName("school_name")
    val schoolName: String = "",
): Serializable {
    private companion object {private const val serialVersionUID = 1L}
}