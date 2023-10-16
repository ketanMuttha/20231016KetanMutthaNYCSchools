package com.nyc.schools.data.remote

import com.nyc.schools.data.model.details.SchoolSatScoresTO
import com.nyc.schools.data.model.landing.SchoolListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Job: This api interface serves to retrieve data using retrofit.
 * Services called:
 * getSchools : retrieve schools list.
 * getSchoolSatScores : retrieve school sat scores.
 * @author Ketan
 */
interface NycSchoolsAPI {

    @GET("/resource/s3k6-pzi2.json")
    suspend fun getSchools(): Response<List<SchoolListItem>>

    @GET("/resource/f9bf-2cp4.json")
    suspend fun getSchoolSatScores(@Query("dbn") dbn:String): Response<List<SchoolSatScoresTO>>
}