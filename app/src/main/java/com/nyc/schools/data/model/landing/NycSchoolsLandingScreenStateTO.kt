package com.nyc.schools.data.model.landing

import java.io.Serializable

sealed class NycSchoolsLandingScreenStateTO: Serializable {

    private companion object{ private const val serialVersionUID =1L}

    object Loading: NycSchoolsLandingScreenStateTO()

    object ErrorTO: NycSchoolsLandingScreenStateTO()

    data class NycSchoolsContentTO(val schoolListItem: List<SchoolListItem> = emptyList()): NycSchoolsLandingScreenStateTO()

}
