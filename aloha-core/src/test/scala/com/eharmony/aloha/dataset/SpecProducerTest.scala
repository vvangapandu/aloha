package com.eharmony.aloha.dataset

import java.lang.reflect.Modifier

import scala.collection.JavaConversions.asScalaSet
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

import org.reflections.Reflections

@RunWith(classOf[BlockJUnit4ClassRunner])
class SpecProducerTest {
    @Test def testAllSpecProducersHaveOnlyZeroArgConstructors() {
        val reflections = new Reflections("com.eharmony.aloha.dataset")
        val specProdClasses = reflections.getSubTypesOf(classOf[SpecProducer[_, _]]).toSet
        specProdClasses.foreach { clazz =>
            val cons = clazz.getConstructors
            assertTrue(s"There should only be one constructor for ${clazz.getCanonicalName}.  Found ${cons.length} constructors.", cons.length <= 1)
            cons.headOption.foreach{ c =>
                val nParams = c.getParameterTypes.length
                assertEquals(s"The constructor for ${clazz.getCanonicalName} should take 0 arguments.  It takes $nParams.", 0, nParams)
            }
        }
    }

    @Test def testAllSpecProducersAreFinalClasses() {
        val reflections = new Reflections("com.eharmony.aloha.dataset")
        val specProdClasses = reflections.getSubTypesOf(classOf[SpecProducer[_, _]]).toSet
        specProdClasses.foreach { clazz =>
            assertTrue(s"${clazz.getCanonicalName} needs to be declared final.", Modifier.isFinal(clazz.getModifiers))
        }
    }
}