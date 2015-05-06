package com.eharmony.matching.featureSpecExtractor.vw.cb.json

import com.eharmony.matching.featureSpecExtractor.json.{Namespace, SparseSpec}
import com.eharmony.matching.featureSpecExtractor.vw.unlabeled.json.VwUnlabeledJsonLike
import spray.json.DefaultJsonProtocol

import scala.collection.{immutable => sci}


case class VwContextualBanditJson(
        imports: Seq[String],
        features: sci.IndexedSeq[SparseSpec],
        namespaces: Option[Seq[Namespace]] = Some(Nil),
        normalizeFeatures: Option[Boolean] = Some(false),
        cbAction: String,
        cbCost: String,
        cbProbability: String)
extends VwUnlabeledJsonLike


object VwContextualBanditJson extends DefaultJsonProtocol {
    implicit val labeledVwJsonFormat = jsonFormat7(VwContextualBanditJson.apply)
}
