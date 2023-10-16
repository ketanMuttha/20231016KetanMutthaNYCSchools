package com.nyc.schools.data.model.details

import com.nyc.schools.data.model.landing.SchoolListItem
import java.io.Serializable

sealed class NycSchoolDetailsScreenStateTO: Serializable {

    private companion object{ private const val serialVersionUID =1L}

    object Loading: NycSchoolDetailsScreenStateTO()

    data class NycSchoolDetailsContentTO(val schoolListItem: SchoolListItem, val schoolSatScoresTO: SchoolSatScoresTO): NycSchoolDetailsScreenStateTO()

    object Error: NycSchoolDetailsScreenStateTO()
}
