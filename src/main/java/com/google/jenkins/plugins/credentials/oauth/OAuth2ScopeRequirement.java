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
package com.google.jenkins.plugins.credentials.oauth;

import java.util.Collection;

import com.cloudbees.plugins.credentials.domains.DomainRequirement;

/**
 * A requirement for a set of OAuth2 scopes
 *
 * NOTE: This should never be implemented directly as scopes do not work
 * across multiple providers.  OAuth2 providers should provide a sub-interface
 * on which to type filter, e.g. {@code GoogleOAuth2ScopeRequirement}
 */
public abstract class OAuth2ScopeRequirement extends DomainRequirement {
  /**
   * The set of oauth scopes required for authenticating the plugin
   * against some service provider.
   */
  public abstract Collection<String> getScopes();
}