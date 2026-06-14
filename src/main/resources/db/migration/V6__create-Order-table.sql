CREATE TABLE "Order" (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    status          TEXT NOT NULL,
    notes           TEXT NOT NULL,
    "userId"        UUID REFERENCES "User"(id),
    "createdAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    "updatedAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_order_user_id ON "Order" ("userId");
