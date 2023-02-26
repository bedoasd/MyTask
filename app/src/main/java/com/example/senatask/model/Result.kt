package com.example.senatask.model

import java.io.Serializable

data class Result(
   /*val `abstract`: String?=null,
    val adx_keywords: String?=null,
    val asset_id: Long,

    val column: Any,
   val des_facet: List<String>,
    val eta_id: Int,
    val geo_facet: List<String>,
    val id: Long,*/
    val id: Long,
    val byline: String?=null,
    val media: List<Media>,
    val nytdsection: String?=null,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: String?=null,
    val section: String?=null,
    val source: String?=null,
    val subsection: String?=null,
    val title: String?=null,
    val type: String?=null,
    val updated: String?=null,
    val uri: String?=null,
    val url: String?=null

) : Serializable