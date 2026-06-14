CREATE TABLE "CartItem" (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "cartId"        UUID NOT NULL REFERENCES "Cart"(id) ON DELETE CASCADE,
    "productId"     UUID NOT NULL REFERENCES "Product"(id),
    quantity        INTEGER NOT NULL,
    "createdAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    "updatedAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    UNIQUE ("cartId", "productId")
);
