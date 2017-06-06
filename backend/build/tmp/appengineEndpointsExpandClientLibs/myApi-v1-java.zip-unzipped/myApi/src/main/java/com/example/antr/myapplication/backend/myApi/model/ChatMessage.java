/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-02-15 17:18:02 UTC)
 * on 2017-06-06 at 04:21:15 UTC 
 * Modify at your own risk.
 */

package com.example.antr.myapplication.backend.myApi.model;

/**
 * Model definition for ChatMessage.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class ChatMessage extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String messageEmail;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double messageLatitude;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double messageLongitude;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String messageText;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long messageTime;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String messageUser;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMessageEmail() {
    return messageEmail;
  }

  /**
   * @param messageEmail messageEmail or {@code null} for none
   */
  public ChatMessage setMessageEmail(java.lang.String messageEmail) {
    this.messageEmail = messageEmail;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getMessageLatitude() {
    return messageLatitude;
  }

  /**
   * @param messageLatitude messageLatitude or {@code null} for none
   */
  public ChatMessage setMessageLatitude(java.lang.Double messageLatitude) {
    this.messageLatitude = messageLatitude;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getMessageLongitude() {
    return messageLongitude;
  }

  /**
   * @param messageLongitude messageLongitude or {@code null} for none
   */
  public ChatMessage setMessageLongitude(java.lang.Double messageLongitude) {
    this.messageLongitude = messageLongitude;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMessageText() {
    return messageText;
  }

  /**
   * @param messageText messageText or {@code null} for none
   */
  public ChatMessage setMessageText(java.lang.String messageText) {
    this.messageText = messageText;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getMessageTime() {
    return messageTime;
  }

  /**
   * @param messageTime messageTime or {@code null} for none
   */
  public ChatMessage setMessageTime(java.lang.Long messageTime) {
    this.messageTime = messageTime;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMessageUser() {
    return messageUser;
  }

  /**
   * @param messageUser messageUser or {@code null} for none
   */
  public ChatMessage setMessageUser(java.lang.String messageUser) {
    this.messageUser = messageUser;
    return this;
  }

  @Override
  public ChatMessage set(String fieldName, Object value) {
    return (ChatMessage) super.set(fieldName, value);
  }

  @Override
  public ChatMessage clone() {
    return (ChatMessage) super.clone();
  }

}
