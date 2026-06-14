CREATE TABLE "OrderItem" (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "orderId"           UUID NOT NULL REFERENCES "Order"(id) ON DELETE CASCADE,
    "productId"         UUID NOT NULL REFERENCES "Product"(id),
    quantity            INTEGER NOT NULL,
    "unitPriceCents"    INTEGER NOT NULL,
    "refundRequestedAt" TIMESTAMPTZ,
    "refundConfirmedAt" TIMESTAMPTZ
);
