# highwind-backend

## API :

### 1. Spaceship

#### 1.1. Create Spaceship

- **URL** : `/spaceship/new`
- **Method** : `POST`
- **Request** : 
```json
{
  "masse" : 100,
  "x" : 100,
  "y" : 100,
  "surfaceVoile" : 100,
  "angleVoile" : 100
}
```
- **Response** : 200
```json
{
  "id": 2,
  "masse": 100,
  "x": 100,
  "y": 100,
  "surfaceVoile": 100,
  "angleVoile": 100.0
}
```

#### 1.2. Get Spaceship

- **URL** : `/spaceship/{id}`
- **Method** : `GET`
- **Response** : 200
```json
{
  "id": 1,
  "masse": 100,
  "x": 100,
  "y": 100,
  "surfaceVoile": 100,
  "angleVoile": 100.0
}
```

#### 1.3. Update Spaceship

- **URL** : `/spaceship/{id}`
- **Method** : `POST`
- **Request** : 
```json
{
  "masse" : 1200,
  "x" : 1200,
  "y" : 1200,
  "surfaceVoile" : 1200,
  "angleVoile" : 1200
}
```
- **Response** : 200
```json
{
  "id": 2,
  "masse": 1200,
  "x": 1200,
  "y": 1200,
  "surfaceVoile": 1200,
  "angleVoile": 1200.0
}
```

#### 1.4. Delete Spaceship

- **URL** : `/api/spaceship/{id}`
- **Method** : `DELETE`
- **Response** : 200
```json
{
    
}
```

