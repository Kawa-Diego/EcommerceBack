CREATE TABLE "Cart" (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "userId"        UUID NOT NULL UNIQUE REFERENCES "User"(id) ON DELETE CASCADE,
    "createdAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    "updatedAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
