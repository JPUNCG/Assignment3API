<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
  <meta charset="UTF-8">
  <title>${title}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h2 class="mb-4">${title}</h2>
  <form method="post" action="/animals">
    <div class="mb-3">
      <label for="name" class="form-label">Animal Name</label>
      <input type="text" class="form-control" id="name" name="name" value="${animal.name!}" required>
    </div>

    <div class="mb-3">
      <label for="description" class="form-label">Description</label>
      <textarea class="form-control" id="description" name="description" rows="3" required>${animal.description!}</textarea>
    </div>

    <div class="mb-3">
      <label for="species" class="form-label">Species</label>
      <input type="text" class="form-control" id="species" name="species" value="${animal.species!}" required>
    </div>

    <div class="mb-3">
      <label for="source" class="form-label">Source</label>
      <input type="text" class="form-control" id="source" name="source" value="${animal.source!}" required>
    </div>

    <div class="mb-3">
      <label for="imageUrl" class="form-label">Image URL</label>
      <input type="text" class="form-control" id="imageUrl" name="imageUrl" value="${animal.imageUrl!}">
      <div class="form-text">Paste a valid image URL to preview the animal image after saving.</div>
    </div>

    <button type="submit" class="btn btn-success">Create Animal</button>
    <a href="/animals" class="btn btn-secondary ms-2">Cancel</a>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>