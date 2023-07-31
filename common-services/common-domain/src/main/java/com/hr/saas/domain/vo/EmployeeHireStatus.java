package com.hr.saas.domain.vo;

public enum EmployeeHireStatus {
    PENDING, // İşe alım başvurusu yapıldı, onay bekleniyor.
    APPROVED, // İşe alım onaylandı, çalışan sisteme eklendi.
    REJECTED, // İşe alım reddedildi.
    CANCELLED // İşe alım süreci iptal edildi.
}

