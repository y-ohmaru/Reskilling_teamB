<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>代金引換とクレジットカード入力</title>
    <script>
        function handlePaymentMethodChange() {
            const radioCashOnDelivery = document.getElementById('cashOnDelivery');
            const creditCardFields = document.querySelectorAll('.credit-card-field');

            if (radioCashOnDelivery.checked) {
                // 代金引換が選択された場合、クレジットカード入力を無効化
                creditCardFields.forEach(field => {
                    field.disabled = true;
                });
            } else {
                // 他の支払い方法が選択された場合、クレジットカード入力を有効化
                creditCardFields.forEach(field => {
                    field.disabled = false;
                });
            }
        }
    </script>
</head>
<body>
    <label>
        <input type="radio" id="cashOnDelivery" name="paymentMethod" value="cashOnDelivery" onchange="handlePaymentMethodChange()">
        代金引換
    </label>
    <label>
        <input type="radio" id="creditCard" name="paymentMethod" value="creditCard" onchange="handlePaymentMethodChange()">
        クレジットカード
    </label>
    <input type="text" class="credit-card-field" placeholder="クレジットカード番号">
    <input type="text" class="credit-card-field" placeholder="クレジットカード名義">
    <input type="text" class="credit-card-field" placeholder="有効期限">
    <input type="text" class="credit-card-field" placeholder="セキュリティコード">
</body>
</html>
