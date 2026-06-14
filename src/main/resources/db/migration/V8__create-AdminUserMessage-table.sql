CREATE TABLE "AdminUserMessage" (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "fromUserId"    UUID NOT NULL REFERENCES "User"(id) ON DELETE CASCADE,
    "toUserId"      UUID NOT NULL REFERENCES "User"(id) ON DELETE CASCADE,
    body            TEXT NOT NULL,
    "readAt"        TIMESTAMPTZ,
    "createdAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_admin_message_to_user ON "AdminUserMessage" ("toUserId");
CREATE INDEX idx_admin_message_created_at ON "AdminUserMessage" ("createdAt");
