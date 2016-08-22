package org.odin.service.webapp.controller;

public interface AssetManifestService {

  AssetManifest fetchAssetManifest();
  void invalidateCache();

}
