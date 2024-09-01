SELECT CONCAT('/home/grep/src/', 
              CONCAT(F.BOARD_ID, 
                     CONCAT('/', 
                            CONCAT(F.FILE_ID, 
                                   CONCAT(F.FILE_NAME, F.FILE_EXT)
                                  )
                            )
                     
                    )
             ) AS FILE_PATH
FROM USED_GOODS_FILE F
INNER JOIN (
                SELECT BOARD_ID
                FROM USED_GOODS_BOARD
                ORDER BY VIEWS DESC
                LIMIT 1
            ) B
        ON B.BOARD_ID = F.BOARD_ID
ORDER BY F.FILE_ID DESC;