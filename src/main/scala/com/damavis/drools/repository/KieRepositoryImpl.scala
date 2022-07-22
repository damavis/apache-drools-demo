package com.damavis.drools.repository

import com.damavis.drools.entity.Rule
import org.drools.template.ObjectDataCompiler
import org.kie.api.KieBase
import org.kie.api.io.ResourceType
import org.kie.internal.utils.KieHelper

import java.io.InputStream
import scala.collection.JavaConverters._

class KieRepositoryImpl extends KieRepository {

  override def getKieBase(rules: Seq[Rule]): KieBase = {
    val template: InputStream         = this.getClass.getClassLoader.getResourceAsStream("template.drl")
    val converter: ObjectDataCompiler = new ObjectDataCompiler
    val drl: String                   = converter.compile(rules.asJava, template)
    val kieBase: KieBase              = new KieHelper().addContent(drl, ResourceType.DRL).build()

    kieBase
  }

}
