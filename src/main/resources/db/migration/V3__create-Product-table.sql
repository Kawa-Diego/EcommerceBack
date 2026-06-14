CREATE TABLE "Product" (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name            TEXT NOT NULL,
    description     TEXT NOT NULL,
    "priceCents"    INTEGER NOT NULL,
    "model3dUrl"    TEXT NOT NULL,
    "categoryId"    UUID NOT NULL REFERENCES "Category"(id),
    "imageUrls"     JSONB NOT NULL DEFAULT '[]',
    "stockQuantity" INTEGER NOT NULL DEFAULT 10,
    "createdAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    "updatedAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
