package com.nyc.schools.data.model.landing

import java.io.Serializable

data class SchoolListItem(
    val addtl_info1: String = "",
    val attendance_rate: String= "",
    val bbl: String = "",
    val bin: String= "",
    val boro:  String= "",
    val borough:  String= "",
    val building_code:  String= "",
    val bus:  String= "",
    val city:  String= "",
    val code1:  String= "",
    val community_board:  String= "",
    val council_district:  String= "",
    val dbn:  String= "",
    val directions1:  String= "",
    val eligibility1:  String= "",
    val extracurricular_activities:  String= "",
    val fax_number:  String= "",
    val finalgrades:  String= "",
    val language_classes:  String= "",
    val latitude:  String= "",
    val location:  String= "",
    val longitude:  String= "",
    val overview_paragraph:  String= "",
    val phone_number:  String= "",
    val primary_address_line_1:  String= "",
    val program1:  String= "",
    val school_email:  String= "",
    val school_name:  String= "",
    val school_sports:  String= "",
    val state_code:  String= "",
    val total_students:  String= "",
    val website:  String= "",
    val zip: String= "",
): Serializable {
    private companion object {private const val serialVersionUID = 1L}
}