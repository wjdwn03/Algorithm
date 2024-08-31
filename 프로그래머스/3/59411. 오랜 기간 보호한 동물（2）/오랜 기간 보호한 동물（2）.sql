SELECT AO.ANIMAL_ID AS ANIMAL_ID, AO.NAME AS NAME
FROM ANIMAL_OUTS AO
INNER JOIN ANIMAL_INS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
ORDER BY DATEDIFF(AO.DATETIME, AI.DATETIME) DESC
LIMIT 2;