.class public Lio/vov/vitamio/utils/Crypto;
.super Ljava/lang/Object;
.source "Crypto.java"


# instance fields
.field private ecipher:Ljavax/crypto/Cipher;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    :try_start_0
    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    invoke-static {p1}, Lio/vov/vitamio/utils/Crypto;->generateKey(Ljava/lang/String;)[B

    move-result-object v2

    const-string v3, "AES"

    invoke-direct {v1, v2, v3}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 39
    .local v1, "skey":Ljavax/crypto/spec/SecretKeySpec;
    invoke-direct {p0, v1}, Lio/vov/vitamio/utils/Crypto;->setupCrypto(Ljavax/crypto/SecretKey;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 43
    .end local v1    # "skey":Ljavax/crypto/spec/SecretKeySpec;
    :goto_0
    return-void

    .line 40
    :catch_0
    move-exception v0

    .line 41
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Crypto"

    invoke-static {v2, v0}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private static generateKey(Ljava/lang/String;)[B
    .locals 4
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 88
    :try_start_0
    const-string v3, "UTF-8"

    invoke-virtual {p0, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .line 89
    .local v0, "bytesOfMessage":[B
    const-string v3, "SHA256"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    .line 90
    .local v2, "md":Ljava/security/MessageDigest;
    invoke-virtual {v2, v0}, Ljava/security/MessageDigest;->digest([B)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 93
    .end local v0    # "bytesOfMessage":[B
    .end local v2    # "md":Ljava/security/MessageDigest;
    :goto_0
    return-object v3

    .line 91
    :catch_0
    move-exception v1

    .line 92
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "generateKey"

    invoke-static {v3, v1}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 93
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static md5(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "plain"    # Ljava/lang/String;

    .prologue
    .line 72
    :try_start_0
    const-string v5, "MD5"

    invoke-static {v5}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v4

    .line 73
    .local v4, "m":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/security/MessageDigest;->update([B)V

    .line 74
    invoke-virtual {v4}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v1

    .line 75
    .local v1, "digest":[B
    new-instance v0, Ljava/math/BigInteger;

    const/4 v5, 0x1

    invoke-direct {v0, v5, v1}, Ljava/math/BigInteger;-><init>(I[B)V

    .line 76
    .local v0, "bigInt":Ljava/math/BigInteger;
    const/16 v5, 0x10

    invoke-virtual {v0, v5}, Ljava/math/BigInteger;->toString(I)Ljava/lang/String;

    move-result-object v3

    .line 77
    .local v3, "hashtext":Ljava/lang/String;
    :goto_0
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    const/16 v6, 0x20

    if-ge v5, v6, :cond_0

    .line 78
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "0"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 81
    .end local v0    # "bigInt":Ljava/math/BigInteger;
    .end local v1    # "digest":[B
    .end local v3    # "hashtext":Ljava/lang/String;
    .end local v4    # "m":Ljava/security/MessageDigest;
    :catch_0
    move-exception v2

    .line 82
    .local v2, "e":Ljava/lang/Exception;
    const-string v3, ""

    .end local v2    # "e":Ljava/lang/Exception;
    :cond_0
    return-object v3
.end method

.method private readKeyFromStream(Ljava/io/InputStream;)Ljava/security/PublicKey;
    .locals 4
    .param p1, "keyStream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 98
    new-instance v1, Ljava/io/ObjectInputStream;

    new-instance v3, Ljava/io/BufferedInputStream;

    invoke-direct {v3, p1}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v1, v3}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V

    .line 100
    .local v1, "oin":Ljava/io/ObjectInputStream;
    :try_start_0
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/security/PublicKey;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 106
    .local v2, "pubKey":Ljava/security/PublicKey;
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->close()V

    .end local v2    # "pubKey":Ljava/security/PublicKey;
    :goto_0
    return-object v2

    .line 102
    :catch_0
    move-exception v0

    .line 103
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v3, "readKeyFromStream"

    invoke-static {v3, v0}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 104
    const/4 v2, 0x0

    .line 106
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->close()V

    goto :goto_0

    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->close()V

    throw v3
.end method

.method private setupCrypto(Ljavax/crypto/SecretKey;)V
    .locals 5
    .param p1, "key"    # Ljavax/crypto/SecretKey;

    .prologue
    .line 46
    const/16 v3, 0x10

    new-array v1, v3, [B

    fill-array-data v1, :array_0

    .line 47
    .local v1, "iv":[B
    new-instance v2, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v2, v1}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    .line 49
    .local v2, "paramSpec":Ljava/security/spec/AlgorithmParameterSpec;
    :try_start_0
    const-string v3, "AES/CBC/PKCS5Padding"

    invoke-static {v3}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v3

    iput-object v3, p0, Lio/vov/vitamio/utils/Crypto;->ecipher:Ljavax/crypto/Cipher;

    .line 50
    iget-object v3, p0, Lio/vov/vitamio/utils/Crypto;->ecipher:Ljavax/crypto/Cipher;

    const/4 v4, 0x1

    invoke-virtual {v3, v4, p1, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 55
    :goto_0
    return-void

    .line 51
    :catch_0
    move-exception v0

    .line 52
    .local v0, "e":Ljava/lang/Exception;
    const/4 v3, 0x0

    iput-object v3, p0, Lio/vov/vitamio/utils/Crypto;->ecipher:Ljavax/crypto/Cipher;

    .line 53
    const-string v3, "setupCrypto"

    invoke-static {v3, v0}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 46
    nop

    :array_0
    .array-data 1
        0x0t
        0x1t
        0x2t
        0x3t
        0x4t
        0x5t
        0x6t
        0x7t
        0x8t
        0x9t
        0xat
        0xbt
        0xct
        0xdt
        0xet
        0xft
    .end array-data
.end method


# virtual methods
.method public encrypt(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "plaintext"    # Ljava/lang/String;

    .prologue
    .line 58
    iget-object v2, p0, Lio/vov/vitamio/utils/Crypto;->ecipher:Ljavax/crypto/Cipher;

    if-nez v2, :cond_0

    .line 59
    const-string v2, ""

    .line 66
    :goto_0
    return-object v2

    .line 62
    :cond_0
    :try_start_0
    iget-object v2, p0, Lio/vov/vitamio/utils/Crypto;->ecipher:Ljavax/crypto/Cipher;

    const-string v3, "UTF-8"

    invoke-virtual {p1, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v3

    invoke-virtual {v2, v3}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v0

    .line 63
    .local v0, "ciphertext":[B
    const/4 v2, 0x2

    invoke-static {v0, v2}, Lio/vov/vitamio/utils/Base64;->encodeToString([BI)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 64
    .end local v0    # "ciphertext":[B
    :catch_0
    move-exception v1

    .line 65
    .local v1, "e":Ljava/lang/Exception;
    const-string v2, "encryp"

    invoke-static {v2, v1}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 66
    const-string v2, ""

    goto :goto_0
.end method

.method public rsaEncrypt(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "keyStream"    # Ljava/io/InputStream;
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 112
    :try_start_0
    const-string v1, "UTF-8"

    invoke-virtual {p2, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {p0, p1, v1}, Lio/vov/vitamio/utils/Crypto;->rsaEncrypt(Ljava/io/InputStream;[B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 114
    :goto_0
    return-object v1

    .line 113
    :catch_0
    move-exception v0

    .line 114
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    const-string v1, ""

    goto :goto_0
.end method

.method public rsaEncrypt(Ljava/io/InputStream;[B)Ljava/lang/String;
    .locals 5
    .param p1, "keyStream"    # Ljava/io/InputStream;
    .param p2, "data"    # [B

    .prologue
    .line 120
    :try_start_0
    invoke-direct {p0, p1}, Lio/vov/vitamio/utils/Crypto;->readKeyFromStream(Ljava/io/InputStream;)Ljava/security/PublicKey;

    move-result-object v3

    .line 121
    .local v3, "pubKey":Ljava/security/PublicKey;
    const-string v4, "RSA/ECB/NoPadding"

    invoke-static {v4}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 122
    .local v0, "cipher":Ljavax/crypto/Cipher;
    const/4 v4, 0x1

    invoke-virtual {v0, v4, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 123
    invoke-virtual {v0, p2}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v1

    .line 124
    .local v1, "cipherData":[B
    const/4 v4, 0x2

    invoke-static {v1, v4}, Lio/vov/vitamio/utils/Base64;->encodeToString([BI)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 127
    .end local v0    # "cipher":Ljavax/crypto/Cipher;
    .end local v1    # "cipherData":[B
    .end local v3    # "pubKey":Ljava/security/PublicKey;
    :goto_0
    return-object v4

    .line 125
    :catch_0
    move-exception v2

    .line 126
    .local v2, "e":Ljava/lang/Exception;
    const-string v4, "rsaEncrypt"

    invoke-static {v4, v2}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 127
    const-string v4, ""

    goto :goto_0
.end method
