CREATE TABLE "AuditLog" (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "userId"        UUID REFERENCES "User"(id),
    action          TEXT NOT NULL,
    details         JSONB,
    "createdAt"     TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_audit_log_user_id ON "AuditLog" ("userId");
CREATE INDEX idx_audit_log_created_at ON "AuditLog" ("createdAt");
