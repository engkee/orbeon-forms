/**
  * Copyright (C) 2016 Orbeon, Inc.
  *
  * This program is free software; you can redistribute it and/or modify it under the terms of the
  * GNU Lesser General Public License as published by the Free Software Foundation; either version
  *  2.1 of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  * See the GNU Lesser General Public License for more details.
  *
  * The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
  */
package org.orbeon.oxf.test

import org.orbeon.oxf.pipeline.api.PipelineContext
import org.orbeon.oxf.webapp.ProcessorService
import org.orbeon.oxf.xforms.XFormsContainingDocument
import org.orbeon.oxf.xforms.action.XFormsAPI.withContainingDocument
import org.scalatest.{BeforeAndAfter, Suite}


trait ResourceManagerSupport extends Suite with BeforeAndAfter {

  ResourceManagerTestBase.staticSetup()

  locally {
    var pipelineContext: Option[PipelineContext] = None

    before { pipelineContext = Some(ResourceManagerTestBase.createPipelineContextWithExternalContext) }
    after  { pipelineContext foreach (_.destroy(true)) }
  }
}
