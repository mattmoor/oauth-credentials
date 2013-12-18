/*
 * Copyright 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.jenkins.plugins.credentials.domains;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.cloudbees.plugins.credentials.domains.DomainRequirement;

/**
 * This annotation is used to indicate that a given class has the specified
 * {@code DomainRequirement}.  This is used to automatically discover the
 * extent of existing requirements, so that the user can specify the necessary
 * requirements from a sufficiently complete list presented in the UI.
 *
 * For Example (URI):
 *  If a plugin only supports https/ssh URIs, we might annotate:
 *  <code>
 *    {@literal @}RequiresDomain(value = SecureURIRequirement.class)
 *  </code>
 *  Even though only one of the two may be necessary, it is sufficient to only
 *  surface the options HTTPS/SSH in the specification UI.
 *
 * For Example (OAuth2):
 *  This is much more important for less constrained spaces than URI schemes,
 *  especially when the options are harder to type options, e.g. OAuth2 scopes.
 *  In this case, a plugin might annotate:
 *  <code>
 *    {@literal @}RequiresDomain(value = OAuth2ScopesABandC.class)
 *  </code>
 *  Even though the task they end up configuring may only require scopes
 *  "A" and "B".
 *
 * @see DomainRequirementProvider
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface RequiresDomain {
  /**
   * The class of {@link DomainRequirement} to which the annotated
   * class adheres.
   */
  // TODO(mattmoor): support a list option
  Class<? extends DomainRequirement> value();
}