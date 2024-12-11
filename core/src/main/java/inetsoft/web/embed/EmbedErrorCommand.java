/*
 * Copyright (c) 2024, InetSoft Technology Corp, All Rights Reserved.
 *
 * The software and information contained herein are copyrighted and
 * proprietary to InetSoft Technology Corp. This software is furnished
 * pursuant to a written license agreement and may be used, copied,
 * transmitted, and stored only in accordance with the terms of such
 * license and with the inclusion of the above copyright notice. Please
 * refer to the file "COPYRIGHT" for further copyright and licensing
 * information. This software and information or any other copies
 * thereof may not be provided or otherwise made available to any other
 * person.
 */

package inetsoft.web.embed;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import inetsoft.web.viewsheet.command.ViewsheetCommand;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableEmbedErrorCommand.class)
public abstract class EmbedErrorCommand implements ViewsheetCommand {
   @Nullable
   public abstract String message();

   public static Builder builder() {
      return new Builder();
   }

   public static class Builder extends ImmutableEmbedErrorCommand.Builder {
   }
}
