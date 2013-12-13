 #Toast
1) Crear un Toast normal
```
Toast tosta = Toast.makeText(this, "text", Toast.LENGHT_SHORT);
```
- Metodos para modificar el Toast

> `tosta.setGravity(GRAVITY.[TOP, LEFT, RIGHT, BOTTOM, CENTER], x, y);`
> `tosta.setDuration(Toast.LENGTH_LONG);`
```
tosta.show();
```

2) Crear un Toast personlizado
```
Toast tosta = new Toast(getApplicationContext());
View layout = getLayoutInflater().inflate(R.layout.layToast, null);
tosta.setView(layout);
tosta.show();
```
