package com.fourfinance.loan.controller;

public interface AssetManifestService {
    AssetManifest fetchAssetManifest();

    void invalidateCache();
}
