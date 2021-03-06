/*
 * This file is part of Total Economy, licensed under the MIT License (MIT).
 *
 * Copyright (c) Eric Grandt <https://www.ericgrandt.com>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.erigitic.config;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.economy.EconomyTransactionEvent;
import org.spongepowered.api.event.impl.AbstractEvent;
import org.spongepowered.api.service.economy.transaction.TransactionResult;

public class TEEconomyTransactionEvent extends AbstractEvent implements EconomyTransactionEvent {

    private TransactionResult transactionResult;

    public TEEconomyTransactionEvent(TransactionResult transactionResult) {
        this.transactionResult = transactionResult;
    }

    @Override
    public Cause getCause() {
        Cause cause = Cause.builder()
                .append(Sponge.getPluginManager().getPlugin("totaleconomy").get())
                .build(EventContext.empty());

        return cause;
    }

    @Override
    public TransactionResult getTransactionResult() {
        return this.transactionResult;
    }
}
