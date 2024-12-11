/*
 * This file is part of StyleBI.
 * Copyright (C) 2024  InetSoft Technology
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package inetsoft.util.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import inetsoft.util.config.crd.CRDProperty;
import inetsoft.util.config.json.PasswordDeserializer;
import inetsoft.util.config.json.PasswordSerializer;

import java.io.Serializable;
import java.util.Objects;

/**
 * {@code S3Config} contains the configuration for S3 storage.
 */
@InetsoftConfigBean
public class S3Config implements Serializable {
   /**
    * The name of the default AWS region.
    */
   public String getRegion() {
      return region;
   }

   public void setRegion(String region) {
      this.region = region;
   }

   /**
    * Sets the access key ID for the IAM account.
    */
   public String getAccessKeyId() {
      return accessKeyId;
   }

   public void setAccessKeyId(String accessKeyId) {
      this.accessKeyId = accessKeyId;
   }

   /**
    * The secure access key for the IAM account.
    */
   @JsonSerialize(using = PasswordSerializer.class)
   @JsonDeserialize(using = PasswordDeserializer.class)
   public String getSecretAccessKey() {
      return secretAccessKey;
   }

   public void setSecretAccessKey(String secretAccessKey) {
      this.secretAccessKey = secretAccessKey;
   }

   /**
    * The endpoint URL of the S3 service.
    */
   public String getEndpoint() {
      return endpoint;
   }

   public void setEndpoint(String endpoint) {
      this.endpoint = endpoint;
   }

   /**
    * Gets the name of the bucket.
    */
   public String getBucket() {
      return bucket;
   }

   public void setBucket(String bucket) {
      Objects.requireNonNull(bucket, "The S3 bucket is required");
      this.bucket = bucket;
   }

   /**
    * The path prefix (directory) in the bucket to use as the root.
    */
   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }

   /**
    * Uses path-style URLs. This should be enabled when using some S3-compatible object stores like
    * MinIO.
    */
   public boolean isPathStyleAccess() {
      return pathStyleAccess;
   }

   public void setPathStyleAccess(boolean pathStyleAccess) {
      this.pathStyleAccess = pathStyleAccess;
   }

   @CRDProperty(description = "The name of the default region")
   private String region;
   @CRDProperty(description = "The access key ID for the IAM account", secret = true)
   private String accessKeyId;
   @CRDProperty(description = "The secret access key for the IAM account", secret = true)
   private String secretAccessKey;
   @CRDProperty(description = "The endpoint URL for the S3 service")
   private String endpoint;
   @CRDProperty(description = "The name of the bucket")
   private String bucket;
   @CRDProperty(description = "The path prefix (directory) in the bucket to use as the root")
   private String path;
   @CRDProperty(description = "A flag that indicates if the store uses path-style URLs. This should be enabled when using some S3-compatible object stores like MinIO.")
   private boolean pathStyleAccess = false;
}
