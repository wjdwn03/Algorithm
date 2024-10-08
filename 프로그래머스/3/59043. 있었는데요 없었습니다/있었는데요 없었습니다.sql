SELECT AI.ANIMAL_ID AS ANIMAL_ID, AI.NAME AS NAME
FROM ANIMAL_INS AI
INNER JOIN ANIMAL_OUTS AO
    ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.DATETIME < AI.DATETIME
ORDER BY AI.DATETIME;