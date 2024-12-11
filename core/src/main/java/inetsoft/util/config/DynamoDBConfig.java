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
 * {@code DynamoDBConfig} contains the configuration for DynamoDB.
 */
@InetsoftConfigBean
public class DynamoDBConfig implements Serializable {
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
    * The optional endpoint URL for the DynamoDB service.
    */
   public String getEndpoint() {
      return endpoint;
   }

   public void setEndpoint(String endpoint) {
      this.endpoint = endpoint;
   }

   /**
    * The name of the DynamoDB table.
    */
   public String getTable() {
      return table;
   }

   public void setTable(String table) {
      Objects.requireNonNull(table, "The DynamoDB table is required");
      this.table = table;
   }

   /**
    * A flag that is {@code true} if on-demand capacity or {@code false} if provisioned capacity is
    * used for the table created by the provider. If the table already exists, this value is
    * ignored.
    */
   public boolean isOnDemandCapacity() {
      return onDemandCapacity;
   }

   public void setOnDemandCapacity(boolean onDemandCapacity) {
      this.onDemandCapacity = onDemandCapacity;
   }

   /**
    * The provisioned read throughput configured for the table if it is created by the provider. If
    * {@link #isOnDemandCapacity()} is {@code true}, this value is ignored.
    */
   public long getProvisionedReadThroughput() {
      return provisionedReadThroughput;
   }

   public void setProvisionedReadThroughput(long provisionedReadThroughput) {
      this.provisionedReadThroughput = provisionedReadThroughput;
   }

   /**
    * The provisioned write throughput configured for the table if it is created by the provider. If
    * {@link #isOnDemandCapacity()} is {@code true}, this value is ignored.
    */
   public long getProvisionedWriteThroughput() {
      return provisionedWriteThroughput;
   }

   public void setProvisionedWriteThroughput(long provisionedWriteThroughput) {
      this.provisionedWriteThroughput = provisionedWriteThroughput;
   }

   @CRDProperty(description = "The name of the default region")
   private String region;
   @CRDProperty(description = "The access key ID for the IAM account", secret = true)
   private String accessKeyId;
   @CRDProperty(description = "The secret access key for the IAM account", secret = true)
   private String secretAccessKey;
   @CRDProperty(description = "The endpoint URL for the DynamoDB service")
   private String endpoint;
   @CRDProperty(description = "The name of the DynamoDB table")
   private String table;
   @CRDProperty(description = "A flag that is true if on-demand capacity or false if provisioned capacity is used fo rthe table created by the provider. If the table already exists, this value is ignored.")
   private boolean onDemandCapacity = true;
   @CRDProperty(description = "The provisioned read throughput configured for the table if it is created by the provider. If onDemandCapacity is true, this value is ignored. ")
   private long provisionedReadThroughput = 0L;
   @CRDProperty(description = "The provisioned write throughput configured for the table if it is created by the provider. If onDemandCapacity is true, this value is ignored. ")
   private long provisionedWriteThroughput = 0L;
}
